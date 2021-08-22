package com.ipl.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.ipl.model.Match;
import com.ipl.model.MatchInput;
import com.ipl.service.MatchProcessor;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

	private final String[] FIELD_NAME = { "id", "city", "date", "player_of_match", "venue", "neutral_venue", "team1",
			"team2", "toss_winner", "toss_decision", "winner", "result", "result_margin", "eliminator", "method",
			"umpire1", "umpire2" };

	@Autowired
	private JobBuilderFactory jobBuilder;

	@Autowired
	private StepBuilderFactory stepBuilder;

	@Bean
	public FlatFileItemReader<MatchInput> reader() {
		return new FlatFileItemReaderBuilder<MatchInput>().name("MatchItemReader")
				.resource(new ClassPathResource("matches.csv")).delimited().names(FIELD_NAME)
				.fieldSetMapper(new BeanWrapperFieldSetMapper<MatchInput>() {
					{
						setTargetType(MatchInput.class);
					}
				}).build();
	}

	@Bean
	public MatchProcessor processor() {
		return new MatchProcessor();
	}

	@Bean
	public JdbcBatchItemWriter<Match> writer(DataSource dataSource) {
		return new JdbcBatchItemWriterBuilder<Match>()
				.itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
				.sql("INSERT INTO match (id,city,date,player_of_match,venue,team1,team2,toss_winner,toss_decision,match_winner,result,result_margin,eliminator,method,umpire1,umpire2)"
						+ " VALUES (:id,:city,:date,:playerOfMatch,:venue,:team1,:team2,:tossWinner,:tossDecision,:matchWinner,:result,:resultMargin,:eliminator,:method,:umpire1,:umpire2)")
				.dataSource(dataSource).build();
	}

	@Bean
	public Job importUserJob(JobCompletionNotificationListener listener, Step step1) {
		return jobBuilder.get("importUserJob").incrementer(new RunIdIncrementer()).listener(listener).flow(step1).end()
				.build();
	}

	@SuppressWarnings("unchecked")
	@Bean
	public Step step1(JdbcBatchItemWriter<Match> writer) {
		return stepBuilder.get("step1").<MatchInput, Match>chunk(10).reader(reader())
				.processor((ItemProcessor<? super MatchInput, ? extends Match>) processor()).writer(writer).build();
	}
}

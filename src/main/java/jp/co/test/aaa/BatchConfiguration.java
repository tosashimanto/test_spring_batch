package jp.co.test.aaa;


import jp.co.test.aaa.JobListener;
import jp.co.test.aaa.Tasklet1;
import jp.co.test.aaa.Tasklet2;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//@Configuration
//@EnableBatchProcessing
//@EnableAutoConfiguration
public class BatchConfiguration {

    @Autowired
    private Tasklet1 tasklet1;
    @Autowired
    private Tasklet2 tasklet2;

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;




    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .tasklet(tasklet1)
                .build();
    }

    @Bean
    public Step step2() {
        return stepBuilderFactory.get("step2")
                .tasklet(tasklet2)
                .build();
    }

    @Bean
    public Job job(Step step1, Step step2) throws Exception {
        return jobBuilderFactory.get("job")
                .incrementer(new RunIdIncrementer())
                .listener(listener())
                .start(step1)
                .next(step2)
                .build();
    }

    @Bean
    public JobExecutionListener listener() {
        return new JobListener();
    }

//    @Bean
//    public Step step1() {
//        return stepBuilderFactory.get("step1")
//                .tasklet(new Tasklet() {
//                    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) {
//                        return null;
//                    }
//                })
//                .build();
//    }
//
//    @Bean
//    public Job job(Step step1) throws Exception {
//        return jobBuilderFactory.get("job1")
//                .incrementer(new RunIdIncrementer())
//                .start(step1)
//                .build();
//    }
}

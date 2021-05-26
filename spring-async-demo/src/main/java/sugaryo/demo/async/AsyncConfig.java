package sugaryo.demo.async;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

/**
 * スレッドプールのBean定義.
 * <p>
 * 実験したい {@link TaskExecutor} のBean定義に {@code @Primary} を付けて SpringBootApplication を実行する。
 * </p>
 * 
 * @author sugaryo
 * 
 * @see TaskExecutor
 * @see ThreadPoolTaskExecutor
 * @see Primary
 * @see EnableAsync
 * @see Async
 */
@Component
public class AsyncConfig {

    @Bean
    public TaskExecutor threadpool1() {

    	var executor = new ThreadPoolTaskExecutor();
    	executor.setCorePoolSize( 2 );
    	executor.setMaxPoolSize( 4 );
    	executor.setQueueCapacity( 10 );
    	executor.setThreadNamePrefix( "pool1-" );
    	return executor;
    }
    
    @Bean
    public TaskExecutor threadpool2() {
    	
    	var executor = new ThreadPoolTaskExecutor();
    	executor.setCorePoolSize( 4 );
    	executor.setMaxPoolSize( 500 );
    	executor.setQueueCapacity( 1 );
    	executor.setThreadNamePrefix( "pool2-" );
    	
    	return executor;
    }
    
    @Bean
    public TaskExecutor threadpool3() {
    	
    	var executor = new ThreadPoolTaskExecutor();
    	executor.setCorePoolSize( 1 );
    	executor.setMaxPoolSize( 500 );
    	executor.setQueueCapacity( 0 );
    	executor.setThreadNamePrefix( "pool3-" );
    	
    	return executor;
    }
    
    @Primary
    @Bean
    public TaskExecutor threadpool4() {
    	
    	var executor = new ThreadPoolTaskExecutor();
    	// core = max 
    	executor.setCorePoolSize( 10 );
    	executor.setMaxPoolSize( 10 );
    	executor.setQueueCapacity( 5 );
    	executor.setThreadNamePrefix( "pool4-" );
    	
    	return executor;
    }
    
    @Bean
    public TaskExecutor poor() {
    	
    	var executor = new ThreadPoolTaskExecutor();
    	executor.setCorePoolSize( 1 );
    	executor.setMaxPoolSize( 4 ); // 4個で限界、5個でRejectされる。
    	executor.setQueueCapacity( 0 );
    	
    	return executor;
    }
    
    
    @Bean
    public TaskExecutor thread100_maxqueue() {
    	
    	var executor = new ThreadPoolTaskExecutor();
    	
    	// 初っ端からフルパワーで100並列で処理する。
    	executor.setCorePoolSize( 100 );
    	executor.setMaxPoolSize( 100 );
    	
    	// 100以上の処理依頼があれば21億までストック。流石に多いか？
    	executor.setQueueCapacity( Integer.MAX_VALUE );
    	executor.setThreadNamePrefix( "100-mxQ-" );
    	
    	return executor;
    }
    
// こういうのはダメ。（デプロイする時にコケる）
//    @Bean
//    public TaskExecutor error() {
//    	
//    	var executor = new ThreadPoolTaskExecutor();
//    	executor.setCorePoolSize( 10 );
//    	executor.setMaxPoolSize( 9 ); // MaxPoolSize < CorePoolSize … NG.
//    	executor.setQueueCapacity( 0 );
//    	
//    	return executor;
//    }
}

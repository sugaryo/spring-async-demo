package sugaryo.demo.async.app;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;


/**
 * 10秒スリープして実行前後のログを出すだけの処理を {@link Async} で非同期処理するサンプルプログラム。
 * 
 * @author sugaryo
 */
@Component
public class TaskModule {
	
	private static final Logger log = LoggerFactory.getLogger( TaskModule.class );
	
	
	@Async
	public void asyncHeavyJob(String token) {
		
		log.info( "▼ task[{}] doing.", token );
		sleep( 10 ); // 10秒スリープする。
		log.info( "▲ task[{}] done.", token );
	}
	
	static void sleep(long seconds) {
		try {
			TimeUnit.SECONDS.sleep( seconds );
		}
		catch (InterruptedException ex) {
			throw new RuntimeException( ex );
		}
	}
}

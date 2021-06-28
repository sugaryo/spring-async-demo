package sugaryo.demo.async.app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;


/**
 * 10秒スリープして実行前後のログを出すだけの処理を {@link Async} で非同期処理するサンプルプログラム。
 * 
 * @author sugaryo
 */
@Component
public class TaskModule {
	
	private static final Logger log = LoggerFactory.getLogger( TaskModule.class );
	
	public String err(final int n ) {
		
		for ( int i = 0; i < n; i++ ) {
			
			long x = i + 1;
			log.info( "count {}", x );
			sleep( 1 );
		}
		throw new RuntimeException( "予期せぬエラーが発生した気持ち" );
	}
	
	public String sync(final int n) {

		log.info( "start" );
		sleep( n );
		log.info( "end" );
		return "done subthread task.";
	}
	
	@Async
	public Future<String> process(final int n) {

		log.info( "start" );
		sleep( n );
		log.info( "end" );
		
		return new AsyncResult<String>( "done subthread task." );
	}
	
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
			log.error( "★★ {}!!", ex.getMessage() );
			//Thread.currentThread().interrupt();
			throw new RuntimeException( ex ); // この例外キャッチされない。
		}
	}
}

package sugaryo.demo.async.app;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskRejectedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/task")
@RestController
public class TaskController {
	
	private static final Logger log = LoggerFactory.getLogger( TaskController.class );
	
	@Autowired
	TaskModule task;
	
	@PostMapping("do")
	public String execute() {
		
		String token = UUID.randomUUID().toString();
		
		log.info( "■ task[{}] requested.", token );
		task.asyncHeavyJob( token );
		
		return token;
	}

	@RequestMapping("proc/err")
	public String proc_e() {

		log.info( "begin sync process() at {}", LocalDateTime.now() );

		// 10秒 処理をやらせる。
		log.info( "main thread task ▼call" );
		var res = this.task.err( 10 );
		log.info( "main thread task ▲called" );

		
		// 完了してないけどとりあえず。
		return "done";
	}
	
	@RequestMapping("proc/sync")
	public String proc_c() {

		log.info( "begin sync process() at {}", LocalDateTime.now() );

		// 10秒 処理をやらせる。
		log.info( "main thread task ▼call" );
		var res = this.task.sync( 10 );
		log.info( "main thread task ▲called" );

		
		// 完了してないけどとりあえず。
		return "done";
	}
	
	@RequestMapping("proc/async")
	public String proc_a() {
		
		log.info( "begin async process() at {}", LocalDateTime.now() );
		
		// 10秒 処理をやらせる。
		log.info( "main thread task ▼call" );
		var await = this.task.process( 10 );
		log.info( "main thread task ▲called" );
		
		// 5秒 待ってから止める
		log.info( "main thread sleep(5)" );
		sleep( 5 );
		log.info( "main thread task stop." );
		await.cancel( true );
		log.info( "main thread task stoped (done={}).", await.isDone() );
		
		
		// 完了してないけどとりあえず。
		return "done";
	}
	@RequestMapping("proc/async2")
	public String proc_b() {
		
		log.info( "begin async process() at {}", LocalDateTime.now() );
		
		// 10秒 処理をやらせる。
		log.info( "main thread task ▼call" );
		var await = this.task.process( 10 );
		log.info( "main thread task ▲called" );
		
		// 5秒 待ってから止める
		log.info( "main thread sleep(5)" );
		sleep( 5 );
		log.info( "main thread task stop." );
		await.cancel( false );
		log.info( "main thread task stoped (done={}).", await.isDone() );
		
		
		// 完了してないけどとりあえず。
		return "done";
	}

	static void sleep(long seconds) {
		try {
			TimeUnit.SECONDS.sleep( seconds );
		}
		catch (InterruptedException ex) {
			throw new RuntimeException( ex );
		}
	}
	
	
    @ExceptionHandler(TaskRejectedException.class)
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public String onTaskRejected() {
    	log.warn( "task thread-pool capacity over" );
        return "too busy";
    }
    
    @ExceptionHandler(InterruptedException.class) 
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public String interrupted() {
    	log.warn( "thread interrupted-exception happened." );
    	return "thread-interrupted...";
    }
    
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public String error() {
    	log.warn( "unexpected-exception happened." );
    	return "unexpected-error!!";
    }
}

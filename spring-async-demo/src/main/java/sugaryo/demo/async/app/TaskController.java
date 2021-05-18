package sugaryo.demo.async.app;

import java.util.UUID;

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
	
	
    @ExceptionHandler(TaskRejectedException.class)
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public String onTaskRejected() {
    	
        return "too busy";
    }
}

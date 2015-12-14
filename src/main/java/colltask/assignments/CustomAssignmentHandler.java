package colltask.assignments;

import java.util.Date;

import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;

public class CustomAssignmentHandler implements TaskListener {
	
//	private static String chosenUser = "";

	public void notify(DelegateTask delegateTask) {
		
//		String taskId = delegateTask.getId();
//		
//		if(taskId.equals("choosePerson")) {
//			chosenUser = (String)delegateTask.getVariable("choosePersonFromList");
//		} else if(taskId.equals("workOnTask")) {
//			delegateTask.setAssignee(chosenUser);
//		} else {
//			//well fuck
//		}
		
		//Postponement handling ----------------------------------------
		boolean allowPostponement = (Boolean) delegateTask.getVariable("allowPostponement");
		
		if(allowPostponement) {
			delegateTask.setVariable("deadline", (Date) delegateTask.getVariable("postponeDate"));
		}
		delegateTask.setDueDate((Date) delegateTask.getVariable("deadline"));
		
		
	}
}

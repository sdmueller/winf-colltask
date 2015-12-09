package colltask.assignments;

import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;

public class CustomAssignmentHandler implements TaskListener {
	
	private static String chosenUser = "";

	public void notify(DelegateTask delegateTask) {
		
		String taskId = delegateTask.getId();
		
		if(taskId.equals("choosePerson")) {
			chosenUser = (String)delegateTask.getVariable("choosePersonFromList");
		} else if(taskId.equals("workOnTask")) {
			delegateTask.setAssignee(chosenUser);
		} else {
			//well fuck
		}
	}
}

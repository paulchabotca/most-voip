package most.voip.api.test;

import java.util.HashMap;

import most.voip.api.VoipLib;
import most.voip.api.enums.BuddyState;
import most.voip.api.enums.CallState;
import most.voip.api.enums.ServerState;
import most.voip.api.enums.VoipEvent;
import most.voip.api.enums.VoipEventType;
import most.voip.api.VoipEventBundle;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class MockVoipLib implements VoipLib{
	
	private static final String TAG = "VoipLibMock";
	private Handler notificationHandler =null;
	private CallState currentCallState = CallState.IDLE;
	
	private void notifyState(VoipEventBundle myStateBundle)
    {
		Log.d(TAG, "Called notifyState for state:" + myStateBundle.getEvent().name());
		switch (myStateBundle.getEvent()){
			case CALL_ACTIVE: this.currentCallState = CallState.ACTIVE; break;
			case CALL_DIALING: this.currentCallState = CallState.DIALING; break;
			case CALL_INCOMING: this.currentCallState = CallState.INCOMING; break;
			case CALL_HOLDING: this.currentCallState = CallState.HOLDING; break;
			case CALL_REMOTE_HOLDING: this.currentCallState = CallState.REMOTE_HOLDING; break;
			case CALL_UNHOLDING: this.currentCallState = CallState.ACTIVE; break; // da gestire il caso di holding e remote holding...
			case CALL_HANGUP: this.currentCallState = CallState.IDLE; break;
			case CALL_REMOTE_HANGUP: this.currentCallState = CallState.IDLE; break;
		default:
			break;}
				
    	Message m = Message.obtain(this.notificationHandler,myStateBundle.getMsgType().ordinal(), myStateBundle);
		m.sendToTarget();
    }

	@Override
	public boolean initLib(Context context, HashMap<String, String> configParams,
			Handler notificationHandler) {
		Log.d(TAG, "Called initLib");
		this.currentCallState = CallState.IDLE;
		this.notificationHandler = notificationHandler;
		this.notifyState(new VoipEventBundle(VoipEventType.LIB_EVENT, VoipEvent.INITIALIZED, "Inizialization Ok", null));
		return true;
	}

	@Override
	public boolean destroyLib() {
		this.currentCallState = CallState.IDLE;
		Log.d(TAG, "Called destroyLib");
		this.notifyState(new VoipEventBundle(VoipEventType.LIB_EVENT, VoipEvent.DEINITIALIZING, "Voip Lib destroying...", null));
		this.simulatePause(1);
		this.notifyState(new VoipEventBundle(VoipEventType.LIB_EVENT, VoipEvent.DEINITIALIZE_DONE, "Voip Lib destroyed", null));
		return true;
	}
    
	private void simulatePause(int secs)
	{
		try {
			Thread.sleep(secs*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean registerAccount() {
		Log.d(TAG, "Called registerAccount");
		this.notifyState(new VoipEventBundle(VoipEventType.ACCOUNT_EVENT, VoipEvent.REGISTERING, "Account Registration request sent", null));
		this.simulatePause(1);
		this.notifyState(new VoipEventBundle(VoipEventType.ACCOUNT_EVENT, VoipEvent.REGISTERED, "Account Registered", null));
		return true;
	}

	@Override
	public boolean unregisterAccount() {
		Log.d(TAG, "Called unregisterAccount");
		this.notifyState(new VoipEventBundle(VoipEventType.ACCOUNT_EVENT, VoipEvent.UNREGISTERING, "Account Unregistration request sent", null));
		this.simulatePause(1);
		this.notifyState(new VoipEventBundle(VoipEventType.ACCOUNT_EVENT, VoipEvent.UNREGISTERED, "Account Unregistered", null));
		return true;
	}

	@Override
	public boolean makeCall(String extension) {
		Log.d(TAG, "Called makeCall");
		{
		this.currentCallState = CallState.DIALING;
		notifyState(new VoipEventBundle(VoipEventType.CALL_EVENT, VoipEvent.CALL_DIALING, "Dialing call to:" + extension, null));
		this.simulatePause(1);
		this.currentCallState = CallState.ACTIVE;
		notifyState(new VoipEventBundle(VoipEventType.CALL_EVENT, VoipEvent.CALL_ACTIVE, "Call active with:" + extension, null));
		}
		return true;
	}

	@Override
	public boolean answerCall() {
		Log.d(TAG, "Called answerCall");
		this.currentCallState = CallState.ACTIVE;
		notifyState(new VoipEventBundle(VoipEventType.CALL_EVENT, VoipEvent.CALL_ACTIVE, "Call active after answering", null));
		return true;
	}

	@Override
	public boolean holdCall() {
		Log.d(TAG, "Called holdCall");
		this.currentCallState = CallState.HOLDING;
		notifyState(new VoipEventBundle(VoipEventType.CALL_EVENT, VoipEvent.CALL_HOLDING, "Call holding", null));
		return true;
	}

	@Override
	public boolean unholdCall() {
		Log.d(TAG, "Called unholdCall");
		this.currentCallState = CallState.ACTIVE;
		notifyState(new VoipEventBundle(VoipEventType.CALL_EVENT, VoipEvent.CALL_UNHOLDING, "Call unholding", null));
		return true;
	}

	@Override
	public boolean hangupCall() {
		this.currentCallState = CallState.IDLE;
		notifyState(new VoipEventBundle(VoipEventType.CALL_EVENT, VoipEvent.CALL_HANGUP, "Call hangup" , null));
		return true;
	}

	@Override
	public CallState getCallState() {
		return this.currentCallState;
	}

	@Override
	public ServerState getServerState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addBuddy(String extension) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeBuddy(String extension) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BuddyState getBuddyState(String extension) {
		// TODO Auto-generated method stub
		return null;
	}
  
}

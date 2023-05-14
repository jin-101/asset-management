package controller;

import java.util.Map;

//모든 controller의 규격서
//데이터의 형식이 어떤것이 들어올지 모르므로 Map타입으로 받는다.
public interface CommonControllerInterface {
	public String execute(Map<String, Object> data) throws Exception;
}

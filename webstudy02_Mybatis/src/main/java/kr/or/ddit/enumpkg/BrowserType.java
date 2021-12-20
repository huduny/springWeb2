package kr.or.ddit.enumpkg;

public enum BrowserType {
	EDG("엣지"), CHROME("크롬"), TRIDENT("익스플로러"), OTHERS("기타");
	private String browserName; //외부에서 안보인다.

	private BrowserType(String browserName) {
		this.browserName = browserName;
	}
	
	public String getBrowserName() {//이 겟을 이용해 데이테를 가져올수 있고 set은 상수이기떄문에 부여하지 않는다.
		return browserName;
	}
	
	public static String findBrowserName(String agent) {//서비스 method, 객체 즉 브라우져를 결정을 못해서 스태틱을 붙인다.
		 return findBrowser(agent).getBrowserName();
	}
	
	public static BrowserType findBrowser(String agent) {//인스턴스를 생성해야만 가능해서 이걸 해결하기 위해 static을
		BrowserType result = OTHERS;
		BrowserType[] values = values(); //모든 값을 가져올수 있는 메서드 키와 밸류롷 되어있다.
		for (BrowserType tmp : values) {
			if(agent.contains(tmp.name())) {
				result = tmp;
				break;
			}
		}
		return result;
	}
}

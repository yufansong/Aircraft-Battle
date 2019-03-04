package playgame;


public class CareTaker {
	
	
	private DB_Operater db_Operater = new DB_Operater();
	private Memento mem = new Memento();
	public Memento getMemento(){
		
		//第一步：从数据库中获取该用户的等级和分数
		int level = db_Operater.get("ljr", "level");
		int score = db_Operater.get("ljr","maxgrade");
		//第二步：吧获取的分数和等级封装到备忘录对象找中，返回
		mem.setLevel(level);
		mem.setScore(score);
		return mem;
	}
	
	public void saveMemento(Memento mem){
		db_Operater.update("ljr", mem.getLevel(), mem.getScore());
	}

}

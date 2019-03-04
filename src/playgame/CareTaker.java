package playgame;


public class CareTaker {
	
	
	private DB_Operater db_Operater = new DB_Operater();
	private Memento mem = new Memento();
	public Memento getMemento(){
		
		//��һ���������ݿ��л�ȡ���û��ĵȼ��ͷ���
		int level = db_Operater.get("ljr", "level");
		int score = db_Operater.get("ljr","maxgrade");
		//�ڶ������ɻ�ȡ�ķ����͵ȼ���װ������¼�������У�����
		mem.setLevel(level);
		mem.setScore(score);
		return mem;
	}
	
	public void saveMemento(Memento mem){
		db_Operater.update("ljr", mem.getLevel(), mem.getScore());
	}

}

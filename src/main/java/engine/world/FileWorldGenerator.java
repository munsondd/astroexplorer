package engine.world;

public class FileWorldGenerator extends WorldGenerator {

	private String path;
	
	public World generate() {
		return super.generate();
	}
	
	public String getPath() {
		return this.path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
}

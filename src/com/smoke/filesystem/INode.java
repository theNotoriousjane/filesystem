package com.smoke.filesystem;

<<<<<<< HEAD

public class INode {
//	文件类型，0表示此INode未使用，1表示为文件，2表示为文件夹
	public int getFileType() {
		return fileType;
	}

	public void setFileType(int fileType) {
		this.fileType = fileType;
	}

	public int getOwner() {
		return owner;
	}
	
	public void setOwner(int owner) {
		this.owner = owner;
	}

	public int[] getPtr() {
		return ptr;
	}

	public void setPtr(int[] ptr) {
		this.ptr = ptr;
	}

	private int fileType;
	private String fileName;
	private int owner;
	private static int size = FileSystem.getInodeSize();
	private int[] ptr;
	
	public INode() {
		fileType = 0;
		owner = 0;
		ptr = new int[size-3];
	}
	
=======
>>>>>>> smoke

public class INode {
	
	private int id;				//	inode号
	private int flag;			//	文件类型，0为空闲inode，1为文件夹，2为文件
	private int owner;			//	文件所属者id,root用户为0
	private int[] ptr;			//	指向存储数据块
	private int[] pos;			//	此inode的位置信息{行，列}
	
	public INode() {
		id = 0;
		flag = 0;
		owner = 0;
		ptr = new int[FileSystem.getInodeSize()-3];
		pos = new int[2];
	}
	
	public INode(int i, int f, int o, int[] p) {
		id = i;
		flag = f;
		owner = o;
		ptr = new int[FileSystem.getInodeSize()-3];
		pos = p;
	}
	
	public void setNextPtr(int ptrNo) {
		/*
		 * 	设置文件存储块指针
		 */
		int i = 0;
		while(ptr[i]!=0 && i<ptr.length) {
			i++;
		}
		ptr[i] = ptrNo;
	}
	
	public void freeINode(){
		flag = 0;
		owner = 0;
		for(int i=0; i<ptr.length; i++) {
			ptr[i] = 0;
		}
	}
	
	@Override
	public String toString() {
		String iNodeStr = "";
		
		return iNodeStr;
	}

	public int getFlag() {
		return flag;
	}

	public void setOwner(int owner) {
		this.owner = owner;
	}

	public int[] getPtr() {
		return ptr;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOwner() {
		return owner;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public int[] getPos() {
		return pos;
	}

	public void setPos(int[] pos) {
		this.pos = pos;
	}

	public void setPtr(int[] ptr) {
		this.ptr = ptr;
	}
	
}

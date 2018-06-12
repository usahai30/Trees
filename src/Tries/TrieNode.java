package Tries;

import java.util.HashMap;

public class TrieNode {
	private	HashMap<Character, TrieNode> children;
	private boolean isWord;
	private String text;
	
	public TrieNode()
	{
		children = new HashMap<Character, TrieNode>();
		isWord = false;
		text = "";		
	}
	
	public boolean add(String toInsert)
	{
		
		return false;
	}
	
	public TrieNode getChild(Character c)
	{
		return children.get(c);
	}
	
	public boolean isWord() {
		return isWord;
	}
	public void setWord(boolean isWord) {
		this.isWord = isWord;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public HashMap<Character, TrieNode> getChildren() {
		return children;
	}
	public void setChildren(HashMap<Character, TrieNode> children) {
		this.children = children;
	}
}

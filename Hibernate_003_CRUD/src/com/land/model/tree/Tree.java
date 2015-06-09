package com.land.model.tree;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Tree {
	private int id;
	private String name;
	private Tree tree;
	private Set<Tree> trees;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@ManyToOne(cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
	@JoinColumn(name="pid")
	public Tree getTree() {
		return tree;
	}
	public void setTree(Tree tree) {
		this.tree = tree;
	}
	
	@OneToMany(mappedBy="tree", cascade={CascadeType.ALL}, fetch=FetchType.EAGER)
	public Set<Tree> getTrees() {
		return trees;
	}
	public void setTrees(Set<Tree> trees) {
		this.trees = trees;
	}
	
}

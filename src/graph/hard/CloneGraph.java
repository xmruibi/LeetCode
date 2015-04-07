package graph.hard;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class CloneGraph {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null)
			return null;
		HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		queue.add(node);
		map.put(node, new UndirectedGraphNode(node.label));
		while (!queue.isEmpty()) {
			UndirectedGraphNode curNode = queue.poll();
			for (int i = 0; i < curNode.neighbors.size(); i++) {
				if (!map.containsKey(curNode.neighbors.get(i))) {
					queue.offer(curNode.neighbors.get(i));
					map.put(curNode.neighbors.get(i), new UndirectedGraphNode(
							curNode.neighbors.get(i).label));
				}
				map.get(curNode).neighbors.add(map.get(curNode.neighbors.get(i)));
			}		
		}
		return map.get(node);
	}
	public UndirectedGraphNode cloneGraphDFS(UndirectedGraphNode node) {
		if (node == null)
			return null;
		HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		Stack<UndirectedGraphNode> stack = new Stack<UndirectedGraphNode>();
		stack.push(node);
		map.put(node, new UndirectedGraphNode(node.label));
		while (!stack.isEmpty()) {
			UndirectedGraphNode curNode = stack.pop();
			for (int i = 0; i < curNode.neighbors.size(); i++) {
				if (!map.containsKey(curNode.neighbors.get(i))) {
					stack.push(curNode.neighbors.get(i));
					map.put(curNode.neighbors.get(i), new UndirectedGraphNode(
							curNode.neighbors.get(i).label));
				}
				map.get(curNode).neighbors.add(map.get(curNode.neighbors.get(i)));
			}		
		}
		return map.get(node);
	}
}

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
}
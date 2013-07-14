import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 
 */

/**
 * @author Simon
 * @see http://leetcode.com/onlinejudge#question_126
 * @problem Given two words (start and end), and a dictionary, find all shortest
 *          transformation sequence(s) from start to end, such that:
 * 
 *          Only one letter can be changed at a time Each intermediate word must
 *          exist in the dictionary For example,
 * 
 *          Given: start = "hit" end = "cog" dict =
 *          ["hot","dot","dog","lot","log"]
 * 
 *          Return
 * 
 *          [ ["hit","hot","dot","dog","cog"], ["hit","hot","lot","log","cog"] ]
 *          Note:
 * 
 *          All words have the same length. All words contain only lowercase
 *          alphabetic characters.
 */
public class WordLadderII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String start = "red";
		String end = "tax";
		HashSet<String> dict = new HashSet<String>();
		String[] input = {"ted","tex","red","tax","tad","den","rex","pee"};
		for (int i = 0; i < input.length; i++) {
			dict.add(input[i]);
		}
		System.out.println(new WordLadderII().findLadders(start, end, dict));
	}

	public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		if (dict.size() == 0)
			return result;
		if (start.length() == 0)
			return result;
		if (isReachable(start, end)){
			ArrayList<String> only = new ArrayList<String>();
			only.add(start);
			only.add(end);
			result.add(only);
			return result;
		}
		if (dict.contains(start)) dict.remove(start);
		if (dict.contains(end)) dict.remove(end);
		ArrayList<String> q = new ArrayList<String>();
		q.add(start);
		ArrayList<String> toReach = new ArrayList<String>();
		HashMap<String, String> parent = new HashMap<String, String>();
		while (dict.size() > 0 || q.size() > 0) {
			boolean flag = true;
			boolean fflag = false;
			while (q.size() > 0) {
				String node = q.remove(0);
				if (isReachable(node, end)){
					parent.put(end, node);
					addResult(start, end, parent, result, new ArrayList<String>());
					fflag = true;
				}
				for (int i = 0; i < node.length(); i++) {
					for (char c = 'a'; c <= 'z'; c++) {
						if (node.charAt(i) == c)
							continue;
						char[] cc = node.toCharArray();
						cc[i] = c;
						String key = String.valueOf(cc);
						if (dict.contains(key)) {
							flag = false;
							if (toReach.contains(key)){
								String newkey = parent.get(key);
								newkey += ";" + node;
								parent.put(key, newkey);
							} else {
								toReach.add(key);
								parent.put(key, node);
							}

						}
					}
				}
			}
			if (flag || fflag)
				return result;
			for (String key : toReach){
				dict.remove(key);
			}
			q = toReach;
//			 System.out.println(toReach);
//			 System.out.println("2:" + dict);
			toReach = new ArrayList<String>();
		}
		return result;
	}
	
	void addResult(String start, String key, HashMap<String, String> parent, ArrayList<ArrayList<String>> result, ArrayList<String> list){
		if(!key.equals(start)){
			String[] keys = key.split(";");
			for (int i = 0; i < keys.length; i++){
				list.add(0, keys[i]);
				addResult(start, parent.get(keys[i]), parent, result, list);
				list.remove(0);
			}
		} else {
			list.add(0, start);
			result.add((ArrayList<String>) list.clone());
			list.remove(0);
		}
	}

	boolean isReachable(String a, String b) {
		int count = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i))
				count++;
			if (count > 1)
				return false;
		}
		if (count == 0)
			return false;
		return true;
	}
}

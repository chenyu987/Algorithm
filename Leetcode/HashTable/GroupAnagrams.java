/**
* Given an array of strings, group anagrams together.
* 
* For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
* Return:
* 
* [
*   ["ate", "eat","tea"],
*   ["nat","tan"],
*   ["bat"]
* ]
* Note: All inputs will be in lower-case.
*/

/*
复杂度
时间:O(n*klogk), where k is the length of longest word in array  空间：O(n)

思路：排序+哈希表
将排序后的单个单词作为key，映射到哈希表中。如果有相应的key存在，则说明之前出现过它的anagrams,把当前词插入存在记录的列表中
如果没有相应的key存在，则创建一条新纪录， 把当前词插进去
*/

public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
	  List<List<String>> res = new ArrayList<List<String>>();
		if (strs == null || strs.length == 0) return res;
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (int i = 0; i < strs.length; i++) {
			char[] sList = strs[i].toCharArray();
			Arrays.sort(sList);
			String str = new String(sList);
			if (map.containsKey(str)) {
				map.get(str).add(strs[i]);
			} else {
				List<String> curList = new ArrayList<String>();
				curList.add(strs[i]);
				map.put(str, curList);
			}
		}
		for (String str : map.keySet()) {
			res.add(map.get(str));
		}
		return res;
 	}
} 
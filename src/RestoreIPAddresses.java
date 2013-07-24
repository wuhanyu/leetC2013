import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Simon@itechs
 * @see http://leetcode.com/onlinejudge#question_93
 * @problem Given a string containing only digits, restore it by returning all
 *          possible valid IP address combinations.
 * 
 *          For example: Given "25525511135",
 * 
 *          return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */
public class RestoreIPAddresses {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "000";
		System.out.println(new RestoreIPAddresses().restoreIpAddresses(s));
	}

    public ArrayList<String> restoreIpAddresses(String s) {
        char[] chs = s.toCharArray();
        ArrayList<String> result = new ArrayList<String>();
        getAddress(chs, 0, 4, result);
        return result;
    }
    
    static int[] addr = new int[4];
    
    void getAddress(char[] chs, int start, int rem, ArrayList<String> result){
        if (start >= chs.length) return;
        if (chs.length - start > rem * 3) return;       
        if (rem == 1) {
    		int num = 0;
    		int p = start;
    		if (start < chs.length - 1 && chs[start] == '0') return;
    		while (p < chs.length){
    			num = num * 10 + (chs[p] - '0');
    			p++;
    		}
    		if (num < 256){
    			String ipaddr = "";
    			for (int i = 0; i < 3; i++){
    				ipaddr += addr[i] + ".";
    			}
    			ipaddr += num;
    			result.add(ipaddr);
    		}
    	} else {
    		int p = start + 1;
    		int num = chs[start] - '0';
            if (num == 0) {
            	addr[4 - rem] = num;
            	getAddress(chs, p, rem - 1, result);
            }
            else {
        		while (p < chs.length && num < 256){
        			addr[4 - rem] = num;
        			getAddress(chs, p, rem - 1, result);
        			num = num * 10 + (chs[p] - '0');
        			p++;		
        		}
            }
    	}
    }
}

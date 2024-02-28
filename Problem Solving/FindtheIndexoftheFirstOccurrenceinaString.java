class Solution {
    public int strStr(String haystack, String needle) {
        int ind=haystack.indexOf(needle);
        if(ind!=-1){
            return ind;
        }
        else{
            return -1;
        }
    }
}
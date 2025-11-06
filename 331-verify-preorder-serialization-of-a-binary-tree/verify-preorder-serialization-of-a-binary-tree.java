class Solution {
    public boolean isValidSerialization(String preorder) {
        if(preorder.equals("") || preorder.equals("#")) return true;
        if(preorder.charAt(0)=='#') return false;
        int slot = 1;
        String[] arr = preorder.split(",");
        for(int i=0;i<arr.length;i++) {
            if(slot == 0) return false;
            if(!arr[i].equals("#")) {
                slot += 1;
            } else {
                slot -= 1;
            }
        }
        return (slot == 0) ? true : false;
    }
}
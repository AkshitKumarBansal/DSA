class Solution {
    public int distMoney(int money, int children) {
        if(money < children) return -1;
        money = money - children;
        int count = 0;
        while(money != 0) {
            if(children == 2 && money == 10) {
                money = 0;
                children = 0;
            } else if(money > 7 && children == 1) {
                money = 0;
                children = 0;
            } else if(money >= 7) {
                money -= 7;
                count++;
                children--;
            } else {
                money = 0;
                children = 0;
            }
        } 
        return count;
    }
}
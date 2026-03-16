class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList<>();
        int idx = 1;
        while( idx <= n ) {
            if( idx % 3 == 0 && idx % 5 == 0 ) {
                answer.add("FizzBuzz");
            } else if( idx % 3 == 0 ) {
                answer.add("Fizz");
            } else if( idx % 5 == 0 ) {
                answer.add("Buzz");
            } else {
                answer.add(String.valueOf(idx));
            }
            idx++;
        }
        return answer;
    }
}
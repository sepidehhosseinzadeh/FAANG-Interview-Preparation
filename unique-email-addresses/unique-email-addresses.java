class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for(String s : emails) {
            String r = s.substring(s.indexOf('@'));
            String l = s.substring(0, s.indexOf('@'));
            l = l.substring(0, l.contains("+") ? l.indexOf("+") : l.length()).replaceAll("\\.", "");
            set.add(l+r);
        }
        return set.size();
    }
}

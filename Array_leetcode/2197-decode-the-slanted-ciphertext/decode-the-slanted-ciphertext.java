class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if (encodedText.isEmpty()) {
            return "";
        }
        
        int cols = encodedText.length() / rows;
        StringBuilder sb = new StringBuilder();
        
        for (int c = 0; c < cols; c++) {
            for (int r = 0, col = c; r < rows && col < cols; r++, col++) {
                sb.append(encodedText.charAt(r * cols + col));
            }
        }
        
        int end = sb.length() - 1;
        while (end >= 0 && sb.charAt(end) == ' ') {
            end--;
        }
        
        return sb.substring(0, end + 1);
    }
}
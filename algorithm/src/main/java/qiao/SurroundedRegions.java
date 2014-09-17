package qiao;

import java.util.HashSet;
import java.util.Set;
/**
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
 * @author liqiao
 *
 */
public class SurroundedRegions {
	public void solve(char[][] board) {
        if(board==null || board.length<3){
                return;
        }
        Set<String> safePos = new HashSet<String>();
        for(int i=0; i<board.length; i++){
            if(board[i][0]=='o'){
                safePos.add(String.valueOf(i)+"-"+String.valueOf(0));
                int j=1;
                while(j<board[i].length){
                    if(board[i][j]=='o'){
                        safePos.add(String.valueOf(i)+"-"+String.valueOf(j));
                        j++;
                    }else{
                        break;
                    }
                }
            }
            if(board[i][board[i].length-1]=='o'){
                safePos.add(String.valueOf(i)+"-"+String.valueOf(board[i].length-1));
                int j = board[i].length - 2;
                while(j>=0){
                    if(board[i][j]=='o'){
                        safePos.add(String.valueOf(i)+"-"+String.valueOf(j));
                        j--;
                    }else{
                        break;
                    }
                }
            }
        }        
        for(int i=0; i<board[0].length; i++){
            if(board[0][i]=='o'){
                safePos.add(String.valueOf(0)+"-"+String.valueOf(i));
                int j=1;
                while(j<board.length){
                    if(board[j][i]=='o'){
                        safePos.add(String.valueOf(j)+"-"+String.valueOf(i));
                        j++;
                    }else{
                        break;
                    }
                }
            }
            if(board[board.length-1][i]=='o'){
                safePos.add(String.valueOf(board.length-1)+"-"+String.valueOf(i));
                int j = board.length - 2;
                while(j>=0){
                    if(board[j][i]=='o'){
                        safePos.add(String.valueOf(j)+"-"+String.valueOf(i));
                        j--;
                    }else{
                        break;
                    }
                }
            }
        }        
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(board[i][j]=='o'){
                    String key = String.valueOf(i)+"-"+String.valueOf(j);
                    if(!safePos.contains(key)){
                        board[i][j] = 'x';
                    }
                }
            }
        }
    }
}

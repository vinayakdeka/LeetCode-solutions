import java.util.*;

class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        
        int startR = -1, startC = -1;
        List<int[]> litters = new ArrayList<>();
        
        // Locate start position 'S' and all litter positions 'L'
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                char ch = classroom[r].charAt(c);
                if (ch == 'S') {
                    startR = r;
                    startC = c;
                } else if (ch == 'L') {
                    litters.add(new int[]{r, c});
                }
            }
        }
        
        int numLitters = litters.size();
        int targetMask = (1 << numLitters) - 1;
        
        // Map litter coordinate (r, c) to its assigned bit index
        int[][] litterMap = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(litterMap[i], -1);
        }
        for (int i = 0; i < numLitters; i++) {
            int[] pos = litters.get(i);
            litterMap[pos[0]][pos[1]] = i;
        }
        
        // Track the maximum remaining energy seen for state: maxEnergy[r][c][mask]
        int[][][] maxEnergy = new int[m][n][1 << numLitters];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(maxEnergy[i][j], -1);
            }
        }
        
        // Queue elements: {row, col, bitmask, currentEnergy, moves}
        Queue<int[]> queue = new LinkedList<>();
        
        int initialMask = 0;
        if (classroom[startR].charAt(startC) == 'L') {
            initialMask |= (1 << litterMap[startR][startC]);
        }
        
        queue.offer(new int[]{startR, startC, initialMask, energy, 0});
        maxEnergy[startR][startC][initialMask] = energy;
        
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            int mask = curr[2];
            int curEnergy = curr[3];
            int moves = curr[4];
            
            // Reached goal: all litters collected
            if (mask == targetMask) {
                return moves;
            }
            
            // Out of energy, cannot transition to adjacent cells
            if (curEnergy == 0) {
                continue;
            }
            
            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && classroom[nr].charAt(nc) != 'X') {
                    int nextEnergy = curEnergy - 1;
                    char cellType = classroom[nr].charAt(nc);
                    
                    // Reset cell restores energy to max capacity
                    if (cellType == 'R') {
                        nextEnergy = energy;
                    }
                    
                    int nextMask = mask;
                    if (cellType == 'L') {
                        int litterIdx = litterMap[nr][nc];
                        if (litterIdx != -1) {
                            nextMask |= (1 << litterIdx);
                        }
                    }
                    
                    // Prune: only process if we arrive with strictly more energy
                    if (nextEnergy > maxEnergy[nr][nc][nextMask]) {
                        maxEnergy[nr][nc][nextMask] = nextEnergy;
                        queue.offer(new int[]{nr, nc, nextMask, nextEnergy, moves + 1});
                    }
                }
            }
        }
        
        return -1;
    }
}
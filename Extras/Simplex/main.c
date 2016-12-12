/*
 Program to solve linear programming problem using simplex method 
 */
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>
#include <assert.h>

#define M 20
#define N 20

static const double e   = 1.0e-8;

int equal(double a, double b) { return fabs(a-b) < e; }

typedef struct {
  int m, n; 
  double STable[M][N];
} SimplexTable;

void nl(int k){ int j; for(j=0;j<k;j++) putchar('-'); putchar('\n'); }

void print_table(SimplexTable *tab, const char* mes) {
  static int counter=0;
  int i, j;
  printf("\n%d. Tableau %s:\n", ++counter, mes);
  nl(70);

  printf("%-6s%5s", "col:", "b[i]");
  for(j=1;j<tab->n; j++) { printf("    x%d,", j); } printf("\n");

  for(i=0;i<tab->m; i++) {
    if (i==0) printf("max:"); else
    printf("b%d: ", i);
    for(j=0;j<tab->n; j++) {
      if (equal((int)tab->STable[i][j], tab->STable[i][j]))
        printf(" %6d", (int)tab->STable[i][j]);
      else
        printf(" %6.2lf", tab->STable[i][j]);
      }
    printf("\n");
  }
  nl(70);
}

void pivot_on(SimplexTable *tab, int row, int col) {
  int i, j;
  double pivot;

  pivot = tab->STable[row][col];
  assert(pivot>0);
  for(j=0;j<tab->n;j++)
    tab->STable[row][j] /= pivot;
  assert( equal(tab->STable[row][col], 1. ));

  for(i=0; i<tab->m; i++) { // foreach remaining row i do
    double multiplier = tab->STable[i][col];
    if(i==row) continue;
    for(j=0; j<tab->n; j++) { // r[i] = r[i] - z * r[row];
      tab->STable[i][j] -= multiplier * tab->STable[row][j];
    }
  }
}

// Find pivot_col = most negative column in mat[0][1..n]
int find_pivot_column(SimplexTable *tab) {
  int j, pivot_col = 1;
  double lowest = tab->STable[0][pivot_col];
  for(j=1; j<tab->n; j++) {
    if (tab->STable[0][j] < lowest) {
      lowest = tab->STable[0][j];
      pivot_col = j;
    }
  }
  printf("Most negative column in row[0] is col %d = %g.\n", pivot_col, lowest);
  if( lowest >= 0 ) {
    return -1; // All positive columns in row[0], this is optimal.
  }
  return pivot_col;
}

// Find the pivot_row, with smallest positive ratio = col[0] / col[pivot]
int find_pivot_row(SimplexTable *tab, int pivot_col) {
  int i, pivot_row = 0;
  double min_ratio = -1;
  printf("Ratios A[row_i,0]/A[row_i,%d] = [",pivot_col);
  for(i=1;i<tab->m;i++){
    double ratio = tab->STable[i][0] / tab->STable[i][pivot_col];
    printf("%3.2lf, ", ratio);
    if ( (ratio > 0  && ratio < min_ratio ) || min_ratio < 0 ) {
      min_ratio = ratio;
      pivot_row = i;
    }
  }
  printf("].\n");
  if (min_ratio == -1)
    return -1; // Unbounded.
  printf("Found pivot A[%d,%d], min positive ratio=%g in row=%d.\n",
      pivot_row, pivot_col, min_ratio, pivot_row);
  return pivot_row;
}

void add_slack_variables(SimplexTable *tab) {
  int i, j;
  for(i=1; i<tab->m; i++) {
    for(j=1; j<tab->m; j++)
      tab->STable[i][j + tab->n -1] = (i==j);
  }
  tab->n += tab->m -1;
}

void check_b_positive(SimplexTable *tab) {
  int i;
  for(i=1; i<tab->m; i++)
    assert(tab->STable[i][0] >= 0);
}

// Given a column of identity matrix, find the row containing 1.
// return -1, if the column as not from an identity matrix.
int find_basis_variable(SimplexTable *tab, int col) {
  int i, xi=-1;
  for(i=1; i < tab->m; i++) {
    if (equal( tab->STable[i][col],1) ) {
      if (xi == -1)
        xi=i;   // found first '1', save this row number.
      else
        return -1; // found second '1', not an identity matrix.

    } else if (!equal( tab->STable[i][col],0) ) {
      return -1; // not an identity matrix column.
    }
  }
  return xi;
}

void print_optimal_vector(SimplexTable *tab, char *message) {
  int j, xi;
  printf("%s at ", message);
  for(j=1;j<tab->n;j++) { // for each column.
    xi = find_basis_variable(tab, j);
    if (xi != -1)
      printf("x%d=%3.2lf, ", j, tab->STable[xi][0] );
    else
      printf("x%d=0, ", j);
  }
  printf("\n");
} 

void simplex(SimplexTable *tab) {
  int loop=0;
  add_slack_variables(tab);
  check_b_positive(tab);
  print_table(tab,"Padded with slack variables");
  while( ++loop ) {
    int pivot_col, pivot_row;

    pivot_col = find_pivot_column(tab);
    if( pivot_col < 0 ) {
      printf("Found optimal value=A[0,0]=%3.2lf (no negatives in row 0).\n",
        tab->STable[0][0]);
      print_optimal_vector(tab, "Optimal vector");
      break;
    }
    printf("Entering variable x%d to be made basic, so pivot_col=%d.\n",
      pivot_col, pivot_col);

    pivot_row = find_pivot_row(tab, pivot_col);
    if (pivot_row < 0) {
      printf("unbounded (no pivot_row).\n");
      break;
    }
    printf("Leaving variable x%d, so pivot_row=%d\n", pivot_row, pivot_row);

    pivot_on(tab, pivot_row, pivot_col);
    print_table(tab,"After pivoting");
    print_optimal_vector(tab, "Basic feasible solution");

    if(loop > 20) {
      printf("Too many iterations > %d.\n", loop);
      break;
    }
  }
}

SimplexTable tab  = { 4, 5, {                     // Size of tableau [4 rows x 5 columns ]
    {  0.0 , -0.5 , -3.0 ,-1.0 , -4.0,   },  // Max: z = 0.5*x + 3*y + z + 4*w,
    { 40.0 ,  1.0 ,  1.0 , 1.0 ,  1.0,   },  //    x + y + z + w <= 40 .. b1
    { 10.0 , -2.0 , -1.0 , 1.0 ,  1.0,   },  //  -2x - y + z + w <= 10 .. b2
    { 10.0 ,  0.0 ,  1.0 , 0.0 , -1.0,   },  //        y     - w <= 10 .. b3
  }
};

int main(int argc, char *argv[]){
  
  print_table(&tab,"Initial");
  simplex(&tab);
  return 0;
} 
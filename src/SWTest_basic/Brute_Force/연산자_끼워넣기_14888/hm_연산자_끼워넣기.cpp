/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   hm_연산자_끼워넣기.cpp                                    :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: hmin <hmin@student.42seoul.kr>             +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/04/21 14:57:56 by hmin              #+#    #+#             */
/*   Updated: 2020/04/21 16:43:03 by hmin             ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

#include <climits>
#include <iostream>
#include <vector>

using namespace std;

int nums_len;
int max_sum = INT_MIN;
int min_sum = INT_MAX;

vector<int> nums;
vector<int> opers; // count each oper: 0(+) 1(-) 2(*) 3(/)

void DFS(int plus, int minus, int multiply, int divide,
		 int oper_cnt,
		 int sum)
{
	// 계산식 완성시
	if (oper_cnt == nums_len)
	{
		if (sum > max_sum)
			max_sum = sum;
		if (sum < min_sum)
			min_sum = sum;
		return;
	}

	// 모든 경우의 수 고려
	if (plus > 0)
		DFS(plus - 1, minus, multiply, divide,
			oper_cnt + 1,
			sum + nums.at(oper_cnt));
	if (minus > 0)
		DFS(plus, minus - 1, multiply, divide,
			oper_cnt + 1,
			sum - nums.at(oper_cnt));
	if (multiply > 0)
		DFS(plus, minus, multiply - 1, divide,
			oper_cnt + 1,
			sum * nums.at(oper_cnt));
	if (divide > 0)
		DFS(plus, minus, multiply, divide - 1,
			oper_cnt + 1,
			sum / nums.at(oper_cnt));
}

int main(void)
{
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	cin >> nums_len;

	// init nums
	for (int i = 0; i < nums_len; i++)
	{
		int num;
		cin >> num;
		nums.push_back(num);
	}

	// init opers
	for (int i = 0; i < 4; i++)
	{
		int oper_cnt;
		cin >> oper_cnt;
		opers.push_back(oper_cnt);
	}

	DFS(opers.at(0), opers.at(1), opers.at(2), opers.at(3),
		1,
		nums.at(0));

	cout << max_sum << "\n";
	cout << min_sum;

	return (0);
}

/*
예제 입력 1
2
5 6
0 0 1 0
예제 출력 1
30
30

예제 입력 2
3
3 4 5
1 0 1 0
예제 출력 2
35
17

예제 입력 3
6
1 2 3 4 5 6
2 1 1 1
예제 출력 3
54
-24

-----
1+2+3-4×5÷6 = 1
1÷2+3+4-5×6 = 12
1+2÷3×4-5+6 = 5
1÷2×3-4+5+6 = 7

-----
입력
첫째 줄에 수의 개수 N(2 ≤ N ≤ 11)가 주어진다. 둘째 줄에는 A1, A2, ..., AN이 주어진다. (1 ≤ Ai ≤ 100) 셋째 줄에는 합이 N-1인 4개의 정수가 주어지는데, 차례대로 덧셈(+)의 개수, 뺄셈(-)의 개수, 곱셈(×)의 개수, 나눗셈(÷)의 개수이다.

출력
첫째 줄에 만들 수 있는 식의 결과의 최댓값을, 둘째 줄에는 최솟값을 출력한다. 최댓값과 최솟값이 항상 -10억보다 크거나 같고, 10억보다 작거나 같은 결과가 나오는 입력만 주어진다. 또한, 앞에서부터 계산했을 때, 중간에 계산되는 식의 결과도 항상 -10억보다 크거나 같고, 10억보다 작거나 같다.
 */

////////////////////////////////////////////////////////////////////////////////

/* @O DFS로 다시 풀어보자.

연산자_끼워넣기_2에서 2중 순열로 풀었더니 TLE 떴다.

https://jaimemin.tistory.com/635
위의 풀이를 보니 얼탱이가 없네ㅋㅋ
순열로 푸는 것보다 훨씬 효율적이고 고오오오급지다.
*/

// #include <algorithm>
// #include <climits>
// #include <iostream>
// #include <vector>

// using namespace std;

// const int PLUS = 0;
// const int MINUS = 1;
// const int MUL = 2;
// const int DIV = 3;

// int num_len;
// int max_val = INT_MIN;
// int min_val = INT_MAX;

// vector<int> nums;
// vector<int> opers; // value: 0(+) 1(-) 2(*) 3(/)

// int main(void)
// {
// 	cin.tie(NULL);
// 	ios_base::sync_with_stdio(false);

// 	// Init nums
// 	cin >> num_len;
// 	for (int i = 0; i < num_len; i++)
// 	{
// 		int num;
// 		cin >> num;
// 		nums.push_back(num);
// 	}

// 	// Init opers
// 	for (int i = 0; i < 4; i++)
// 	{
// 		int oper_cnt;
// 		cin >> oper_cnt;
// 		for (int j = 0; j < oper_cnt; j++)
// 			opers.push_back(i);
// 	}

// 	// Calc max_val, min_val
// 	do
// 	{
// 		int val = nums.at(0);
// 		for (int i = 1; i < num_len; i++)
// 		{
// 			int oper = opers.at(i - 1);
// 			if (oper == PLUS)
// 				val += nums.at(i);
// 			else if (oper == MINUS)
// 				val -= nums.at(i);
// 			else if (oper == MUL)
// 				val *= nums.at(i);
// 			else if (oper == DIV)
// 				val /= nums.at(i);
// 		}
// 		max_val = (val > max_val) ? val : max_val;
// 		min_val = (val < min_val) ? val : min_val;
// 	} while (next_permutation(opers.begin(), opers.end()));

// 	cout << max_val << "\n";
// 	cout << min_val << "\n";
// 	return (0);
// }

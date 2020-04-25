/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   hm_연산자_끼워넣기2.cpp                                   :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: hmin <hmin@student.42seoul.kr>             +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/04/22 13:32:22 by hmin              #+#    #+#             */
/*   Updated: 2020/04/22 13:36:50 by hmin             ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

/*
연산자 끼워넣기 1을 순열로 풀고,
연사자 끼워넣기 2를 2중 순열로 풀면 어려운 문제이다.
(심지어 2중 순열을 쓰면 타임오버가 뜬다.)

하지만, dfs로 아래와 같은 로직으로 풀게 되면
1번 문제든 2번 문제든 상관없이 문제가 풀리게 된다.
그것도 아주 효율적으로.

하고싶은 말은 이거다.

1번 해답 그대로 복붙했음.
 */

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

/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   hm_N과M9.cpp                                        :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: hmin <hmin@student.42seoul.kr>             +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/03/05 22:00:28 by hmin              #+#    #+#             */
/*   Updated: 2020/03/05 22:41:49 by hmin             ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

const int N_MAX = 8;
const int M_MAX = 8;

int n, m;
bool visited[N_MAX];
// 방문한 인덱스
int group[M_MAX];
// 가능한 순열 그룹
vector<int> digit;
// 인덱스와 매치되는 숫자
// 숫자 값 넣고 Sorting 필수!

void dfs(int depth)
{
	// //! PRINT ALL
	// string s = "=== ";
	// for (int i = 0; i < m; i++)
	// {
	// 	s += to_string(group[i]) + " ";
	// }
	// cout << s << "\n";
	// //!

	if (depth == m)
	{
		for (int i = 0; i < m; i++)
			cout << group[i] << " ";
		cout << "\n";
		return;
	}
	// N과 M 5번에서 추가된 것은 last_digit 뿐.
	//
	// vector<string> printed; 를 전역으로 선언해서
	// if(isPrinted) 방식으로 중복을 방지하려 했으나,
	// 곧바로 시간초과로 이어지게 되어, 결국 인터넷 해답을 참고.
	//
	// 확실히 call stack이 몇 단계 쌓여있는지 depth의 흐름을
	// 읽어나갈 수 있어야만 떠올릴 수 있는 중복 방지법이다.
	int last_digit = -1;
	for (int i = 0; i < n; i++)
	{
		// i     : 0    1    2    3
		// digit : 1    9    9    9
		if (!visited[i] && (i == 0 || last_digit != digit.at(i)))
		{
			last_digit = digit.at(i);
			group[depth] = digit.at(i);
			visited[i] = true;
			dfs(depth + 1);
			visited[i] = false;
		}
	}
}

int main(void)
{
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	cin >> n >> m;
	// 4 3
	for (int i = 0; i < n; i++)
	{
		int tmp;
		cin >> tmp;
		digit.push_back(tmp);
	}
	// digit : 9 1 9 9
	sort(digit.begin(), digit.end());
	// digit : 1 9 9 9
	dfs(0);
	return (0);
}

/*
4 3
9 1 9 9

1 9 9
9 1 9
9 9 1
9 9 9
 */

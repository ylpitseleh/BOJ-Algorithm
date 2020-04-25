/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   hm_N과M7.cpp                                        :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: hmin <hmin@student.42seoul.kr>             +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/03/05 21:03:42 by hmin              #+#    #+#             */
/*   Updated: 2020/03/05 21:20:27 by hmin             ###   ########.fr       */
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
// bool visited[N_MAX];
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
	for (int i = 0; i < n; i++)
	{
		// i     : 0    1    2    3
		// digit : 1111 2345 6543 9999
		// if (!visited[i])
		// {
		group[depth] = digit.at(i);
		// if (depth > 0 && group[depth - 1] > group[depth])
			// continue;
		dfs(depth + 1);
		// }
	}
}

int main(void)
{
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	cin >> n >> m;
	// 4 2
	for (int i = 0; i < n; i++)
	{
		int tmp;
		cin >> tmp;
		digit.push_back(tmp);
	}
	// digit : 9999 6543 2345 1111
	sort(digit.begin(), digit.end());
	// digit : 1111 2345 6543 9999
	dfs(0);
	return (0);
}

/*
4 2
9999 1111 6543 2345

1111 1111
1111 2345
1111 6543
1111 9999
2345 1111
2345 2345
2345 6543
2345 9999
6543 1111
6543 2345
6543 6543
6543 9999
9999 1111
9999 2345
9999 6543
9999 9999
 */

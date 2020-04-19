/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   hm_N과M12.cpp                                       :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: hmin <hmin@student.42seoul.kr>             +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/03/05 22:42:19 by hmin              #+#    #+#             */
/*   Updated: 2020/03/06 03:40:04 by hmin             ###   ########.fr       */
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

	int last_digit = -1;
	for (int i = 0; i < n; i++)
	{
		// i     : 0 1 2 3 4
		// digit : 1 2 3 9 9
		if (last_digit != digit.at(i))
		{
			last_digit = digit.at(i);
			group[depth] = digit.at(i);
			if (depth > 0 && group[depth - 1] > group[depth])
				continue;
			dfs(depth + 1);
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
	// digit : 9 3 9 2 1
	sort(digit.begin(), digit.end());
	// digit : 1 2 3 9 9
	dfs(0);
	return (0);
}

/*
5 3
9 3 9 2 1

1 1 1
1 1 2
1 1 3
1 1 9
1 2 2
1 2 3
1 2 9
1 3 3
1 3 9
1 9 9
2 2 2
2 2 3
2 2 9
2 3 3
2 3 9
2 9 9
3 3 3
3 3 9
3 9 9
9 9 9
 */

/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   hm_N과M3.cpp                                        :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: hmin <hmin@student.42seoul.kr>             +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/03/05 17:36:19 by hmin              #+#    #+#             */
/*   Updated: 2020/03/05 18:12:08 by hmin             ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

#include <iostream>
#include <string>

using namespace std;

const int N_MAX = 7;
const int M_MAX = 7;

int n, m;
int arr[M_MAX];

// 메모리: 1984 KB
// 시간: 380ms
/*
void dfs(int depth)
{
	if (depth == m)
	{
		for (int i = 0; i < m; i++)
			cout << arr[i] << " ";
		cout << "\n";
		// 여기다가 return ;을 넣으면 20ms 가 절약되지만,
		//
		// 개인적으로, return 및 break 등의 남용은 코드 흐름을 읽기 어렵게
		// 만든다고 생각하기에, 사용하지 않았음.
	}
	else
	{
		for (int d = 1; d <= n; d++)
		{
			arr[depth] = d;
			dfs(depth + 1);
		}
	}
}
 */

// 메모리: 1984 KB
// 시간: 192ms
void recur(int depth, string str)
{
	// cout << "===" << str << "\n"; // 이걸 붙이면 재귀의 흐름을 파악하기 쉬움
	if (depth == m)
		cout << str << "\n";
	else
		for (int d = 1; d <= n; d++)
			recur(depth + 1, str + to_string(d) + " ");
}

int main(void)
{
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	cin >> n >> m;
	// dfs(0);
	recur(0, "");

	return (0);
}

////////////////////////////////////////////////////////////////////////////////
/*
4 2

1 2
1 3
1 4
2 3
2 4
3 4
*/

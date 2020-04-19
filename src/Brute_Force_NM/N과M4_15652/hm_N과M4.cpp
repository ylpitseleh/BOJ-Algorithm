/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   test.cpp                                           :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: hmin <hmin@student.42seoul.kr>             +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/03/05 19:26:18 by hmin              #+#    #+#             */
/*   Updated: 2020/03/05 20:15:47 by hmin             ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

#include <iostream>
#include <string>

using namespace std;

const int N_MAX = 8;
const int M_MAX = 8;

int n, m;
bool visited[N_MAX + 1];
int arr[M_MAX];

void dfs(int depth)
{
	// //! PRINT ALL
	// string s = "=== ";
	// for (int i = 0; i < m; i++)
	// {
	// 	s += to_string(arr[i]) + " ";
	// }
	// cout << s << "\n";
	// //!

	if (depth == m)
	{
		string tmp = "";
		for (int i = 0; i < m; i++)
		{
			if (i > 0 && arr[i - 1] > arr[i])
				return;
			tmp += to_string(arr[i]) + " ";
		}
		cout << tmp << "\n";
		return;
	}
	for (int d = 1; d <= n; d++)
	{
		arr[depth] = d;
		if (depth > 0 && arr[depth - 1] > arr[depth])
			continue;
		dfs(depth + 1);
		//  N과 M 2번 문제와 비슷
		//	if (!visited[d])
		//	{
		//		visited[d] = true;
		//		arr[depth] = d;
		//		dfs(depth + 1);
		//		visited[d] = false;
		//	}
	}
}

int main(void)
{
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	cin >> n >> m;
	dfs(0);
	return (0);
}

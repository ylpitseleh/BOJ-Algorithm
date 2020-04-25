/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   hm_n과m2.cpp                                        :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: hmin <hmin@student.42seoul.kr>             +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/03/05 17:24:13 by hmin              #+#    #+#             */
/*   Updated: 2020/03/05 17:34:37 by hmin             ###   ########.fr       */
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
	if (depth == m)
	{
		string tmp = "";
		for (int i = 0; i < m; i++)
		{
			if (i > 0 && arr[i-1] > arr[i])
				return ;
			tmp += to_string(arr[i]) + " ";
		}
		cout << tmp << "\n";
		return;
	}
	for (int d = 1; d <= n; d++)
	{
		if (!visited[d])
		{
			visited[d] = true;
			arr[depth] = d;
			dfs(depth + 1);
			visited[d] = false;
		}
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

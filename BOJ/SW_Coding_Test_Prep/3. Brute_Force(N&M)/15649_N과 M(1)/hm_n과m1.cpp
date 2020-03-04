/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   hm_n과m1.cpp                                        :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: hmin <hmin@student.42seoul.kr>             +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/03/04 13:13:57 by hmin              #+#    #+#             */
/*   Updated: 2020/03/04 15:37:33 by hmin             ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

// 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
// 첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)

static int n, m;
static bool *visited;
static int *arr;

void dfs(int depth)
{
	if (depth == m)
	{
		for (int i = 0; i < m; i++)
			cout << arr[i] << " ";
		cout << endl;
		return;
	}

	for (int i = 1; i <= n; i++)
	{
		if (!visited[i])
		{
			visited[i] = true;
			arr[depth] = i;
			dfs(depth + 1);
			visited[i] = false;
		}
	}
}

int main(void)
{
	cin >> n >> m;
	visited = new bool[n + 1];
	arr = new int[m];

	dfs(0);
	return (0);
}

/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   hm_DFS와_BFS.cpp                                    :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: hmin <hmin@student.42seoul.kr>             +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/03/06 01:06:41 by hmin              #+#    #+#             */
/*   Updated: 2020/03/08 21:26:27 by hmin             ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

/*
정점의 개수    N  1 <= N <= 1000
간선의 개수    M  1 <= M <= 10000
시작 정점 번호 start
 */

#include <iostream>
#include <queue>

using namespace std;

const int MAX = 1001;

int n, m, start;
bool isAdj[MAX][MAX];
bool isVisited[MAX];

// 재귀 사용 (== 스택 사용)
void dfs(int start)
{
	cout << start << " ";
	isVisited[start] = true;
	for (int i = 1; i <= n; i++)
	{
		if (!isVisited[i] && isAdj[start][i])
			dfs(i);
	}
}

// 큐 사용
void bfs(int start)
{
	queue<int> q;
	q.push(start);
	isVisited[start] = true;

	while (!q.empty())
	{
		start = q.front();
		q.pop();
		cout << start << " ";
		for (int i=1; i<=n; i++)
		{
			if (!isVisited[i] && isAdj[start][i])
			{
				q.push(i);
				isVisited[i] = true;
			}
		}
	}
}

int main(void)
{
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	cin >> n >> m >> start;
	int x, y;
	for (int i = 0; i < m; i++)
	{
		cin >> x >> y;
		isAdj[x][y] = isAdj[y][x] = 1;
	}
	dfs(start);
	cout << "\n";

	for (int i = 1; i <= n; i++)
		isVisited[i] = false;
	// 그냥 이렇게 false로 채워줄 필요 없이
	// bfs에서는 dfs에서와 반대로
	// isVisited[start] = false;
	// 를 사용해도 되지만, 퍼포먼스를 조금 포기해도
	// 가독성을 높이는 게 낫다고 생각하기에
	// 굳이 이렇게 초기화 해주었음.

	bfs(start);
	return (0);
}

/*
4 5 1
1 2
1 3
1 4
2 4
3 4

1 2 4 3
1 2 3 4
 */

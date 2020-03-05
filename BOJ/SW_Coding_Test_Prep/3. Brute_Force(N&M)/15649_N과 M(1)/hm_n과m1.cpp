/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   hm_N과M1.cpp                                        :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: hmin <hmin@student.42seoul.kr>             +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/03/04 13:13:57 by hmin              #+#    #+#             */
/*   Updated: 2020/03/05 16:53:30 by hmin             ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

/*
1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)

즉, 이 문제는 순열 nPr의 모든 경우의 수를 나열하는 문제이다.

현재 아래의 풀이는 순열을 어떻게 구현할지 도저히 감이 오질 않아, 블로그에서
백트래킹을 사용한 로직 및 해답을 그대로 베껴온 것에 불과하다.

또한, 순열의 모든 경우의 수를 나열하는 방법은 백트래킹 이외에도 스택을 활용하거나 다중 중첩 반복문을 활용하는 것도 가능한 듯 하다.

언젠가 이런 로직도 자연스럽게 구상하게 되는 날이 올까..?
... 그냥 일단은 암기해야겠다.
 */

/*
본격적으로 문제를 풀기 전에 주의해야 할 점이 있다. 입출력 방식이 느리면 여러 줄을 입력받거나 출력할 때 시간초과가 날 수 있다는 점이다.

C++을 사용하고 있고 cin/cout을 사용하고자 한다면, cin.tie(NULL)과 sync_with_stdio(false)를 둘 다 적용해 주고, endl 대신 개행문자(\n)를 쓰자. 단, 이렇게 하면 더 이상 scanf/printf/puts/getchar/putchar 등 C의 입출력 방식을 사용하면 안 된다.

https://www.acmicpc.net/problem/15552 (빠른 A+B)
https://www.acmicpc.net/board/view/22716 (추가 설명 및 다른 언어 빠른 입출력 방법)
 */

#include <algorithm>
#include <iostream>
#include <vector>
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
			cout << arr[i] << " ";
		// cout << endl; // 시간초과 원인
		cout << "\n";
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
// 5P3 == 5!/2! == 120/2 == 60
5 3
1 2 3
1 2 4
1 2 5
1 3 2
1 3 4
1 3 5
1 4 2
1 4 3
1 4 5
1 5 2
1 5 3
1 5 4
2 1 3
2 1 4
2 1 5
2 3 1
2 3 4
2 3 5
2 4 1
2 4 3
2 4 5
2 5 1
2 5 3
2 5 4
3 1 2
3 1 4
3 1 5
3 2 1
3 2 4
3 2 5
3 4 1
3 4 2
3 4 5
3 5 1
3 5 2
3 5 4
4 1 2
4 1 3
4 1 5
4 2 1
4 2 3
4 2 5
4 3 1
4 3 2
4 3 5
4 5 1
4 5 2
4 5 3
5 1 2
5 1 3
5 1 4
5 2 1
5 2 3
5 2 4
5 3 1
5 3 2
5 3 4
5 4 1
5 4 2
5 4 3
*/

/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   hm_외판원_순회_2.cpp                                    :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: hmin <hmin@student.42seoul.kr>             +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/03/09 17:20:00 by hmin              #+#    #+#             */
/*   Updated: 2020/03/09 19:23:16 by hmin             ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

#include <algorithm>
#include <climits>
#include <iostream>
#include <vector>

using namespace std;

/*
4           (2 ~ 10)
0 10 15 20  (0 ~ 1,000,000)
5  0  9 10
6 13  0 12
8  8  9  0

35
 */

const int MAX_N = 10;

int n;
int min_dist = INT_MAX;
int map[MAX_N][MAX_N];
vector<int> route;

void update_min_dist()
{
	int dist = 0;
	for (int i = 0; i < n; i++)
	{
		int gap = map[route.at(i)][route.at(i + 1)];
		if (gap == 0)
			return;
		else
			dist += gap;
	}
	min_dist = dist < min_dist ? dist : min_dist;
}

int main(void)
{
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	cin >> n;
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			cin >> map[i][j];
		}
		route.push_back(i);
	}
	route.push_back(0);
	// if n == 5
	// 0 1 2 3 4 0

	do
	{
		update_min_dist();
	} while (next_permutation(route.begin() + 1, route.end() - 1));

	cout << min_dist;
	return (0);
}

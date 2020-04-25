/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   hm_차이를_최대로.cpp                                     :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: hmin <hmin@student.42seoul.kr>             +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/03/09 02:11:30 by hmin              #+#    #+#             */
/*   Updated: 2020/03/09 17:25:18 by hmin             ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

/*
3 ≤ N ≤ 8
-100 <= A <= 100

|A[0] - A[1]| + |A[1] - A[2]| + ... + |A[N-2] - A[N-1]|
-----------
6
20 1 15 8 4 10

62
 */

#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int n;
int max_sum = -1;
vector<int> nums;

void update_max_sum()
{
	int sum = 0;
	for (int i = 0; i < n - 1; i++)
	{
		int diff;
		diff = nums.at(i) - nums.at(i + 1);
		sum += diff >= 0 ? diff : -diff;
	}
	max_sum = sum > max_sum ? sum : max_sum;
}

int main(void)
{
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	cin >> n;
	for (int i = 0; i < n; i++)
	{
		int num;
		cin >> num;
		nums.push_back(num);
	}
	sort(nums.begin(), nums.end());

	do
	{
		update_max_sum();
	} while (next_permutation(nums.begin(), nums.end()));

	cout << max_sum;
	return (0);
}

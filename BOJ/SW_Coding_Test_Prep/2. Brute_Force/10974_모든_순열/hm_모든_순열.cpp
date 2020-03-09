/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   hm_모든_순열.cpp                                       :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: hmin <hmin@student.42seoul.kr>             +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/03/09 01:14:40 by hmin              #+#    #+#             */
/*   Updated: 2020/03/09 19:35:30 by hmin             ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

#include <iostream>
#include <vector>

using namespace std;

int len;
vector<int> nums;

void swap_num(int idx1, int idx2)
{
	int tmp;
	tmp = nums.at(idx1);
	nums.at(idx1) = nums.at(idx2);
	nums.at(idx2) = tmp;
}

/*
#include <algorithm>
next_permutation(v.begin(), v.end()); //arr도 가능
위와 같이 STL을 사용할 수도 있지만, 일단 다음 순열 문제 푼 것을 활용.
 */

bool my_next_permutation()
{
	// idx1: 뒤에서부터 탐색하면서 오름차순이 깨지는 인덱스를 확인
	int idx1 = len - 2;
	while (idx1 >= 0 && nums.at(idx1) >= nums.at(idx1 + 1))
		idx1--;
	if (idx1 == -1)
		return (false);

	// idx2: 다시 뒤에서부터 탐색하면서 idx1보다 큰 첫 번째 인덱스를 확인
	int idx2 = len - 1;
	while (nums.at(idx1) >= nums.at(idx2))
		idx2--;

	// idx1과 idx2를 스왑
	swap_num(idx1, idx2);

	// idx1 + 1에서부터 끝까지 오름차순 정렬
	int start = idx1 + 1;
	int end = len - 1;
	while (start < end)
		swap_num(start++, end--);
	return (true);
}

/*
dfs를 사용해서 풀었던 "N과 M (1)" 문제의 코드로도 제출해 보니,
둘 다 20ms로 같은 결과가 나왔음.
 */

int main(void)
{
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	// init nums & print it
	cin >> len;
	for (int i = 0; i < len; i++)
	{
		cout << i + 1 << " ";
		nums.push_back(i + 1);
	}
	cout << "\n";

	while (my_next_permutation())
	{
		// 결과값 출력
		for (int i = 0; i < len; i++)
			cout << nums.at(i) << " ";
		cout << "\n";
	}

	return (0);
}

/*
3

1 2 3
1 3 2
2 1 3
2 3 1
3 1 2
3 2 1
 */

/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   hm_로또.cpp                                          :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: hmin <hmin@student.42seoul.kr>             +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/03/09 19:32:41 by hmin              #+#    #+#             */
/*   Updated: 2020/03/09 20:46:33 by hmin             ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

/*
https://twpower.github.io/90-combination-by-using-next_permutation

next_permutation을 이용해 조합(Combinataion) 구하기

전체 n개의 원소들 중에서 k개를 뽑는 조합(=nCk)을 구한다면 n개의 벡터 원소에 1을 k개 0을 나머지인 n-k개 집어넣어서 순열을 돌리고 1에 해당하는 인덱스만 가져오면 된다.

--------
조합을 어떻게 구현할 지 감이 잡힐 듯 말 듯 너무 답답해서 결국 검색 후 핵심 로직만 참고했음.
 */

#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int len;

vector<int> group;  // 로또 숫자 집합
vector<int> picker; // 로또 숫자 집합에서 6개 선택 ex) 8C6 {1,1,0,1,1,1,0,1}

int main(void)
{
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	while (1)
	{
		cin >> len; // 6 < len < 13
		if (len == 0)
			break;

		// init & input
		group.clear();
		picker.clear();
		for (int i = 0; i < len; i++) // 원소는 오름차순으로 주어짐
		{
			int num;
			cin >> num;
			group.push_back(num);
			if (i < 6)
				picker.push_back(1);
			else
				picker.push_back(0);
		}

		// print
		do
		{
			for (int i = 0; i < len; i++)
				if (picker.at(i) == 1)
					cout << group.at(i) << " ";
			cout << "\n";
		} while (prev_permutation(picker.begin(), picker.end()));

		cout << "\n";
	}

	return (0);
}

/*
7 1 2 3 4 5 6 7
8 1 2 3 5 8 13 21 34
0

1 2 3 4 5 6
1 2 3 4 5 7
1 2 3 4 6 7
1 2 3 5 6 7
1 2 4 5 6 7
1 3 4 5 6 7
2 3 4 5 6 7

1 2 3 5 8 13
1 2 3 5 8 21
1 2 3 5 8 34
1 2 3 5 13 21
1 2 3 5 13 34
1 2 3 5 21 34
1 2 3 8 13 21
1 2 3 8 13 34
1 2 3 8 21 34
1 2 3 13 21 34
1 2 5 8 13 21
1 2 5 8 13 34
1 2 5 8 21 34
1 2 5 13 21 34
1 2 8 13 21 34
1 3 5 8 13 21
1 3 5 8 13 34
1 3 5 8 21 34
1 3 5 13 21 34
1 3 8 13 21 34
1 5 8 13 21 34
2 3 5 8 13 21
2 3 5 8 13 34
2 3 5 8 21 34
2 3 5 13 21 34
2 3 8 13 21 34
2 5 8 13 21 34
3 5 8 13 21 34
 */

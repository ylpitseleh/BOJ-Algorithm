/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   hm_빠른_A_B.cpp                                      :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: hmin <hmin@student.42seoul.kr>             +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/03/05 17:12:30 by hmin              #+#    #+#             */
/*   Updated: 2020/03/05 17:24:54 by hmin             ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

/*
본격적으로 문제를 풀기 전에 주의해야 할 점이 있다. 입출력 방식이 느리면 여러 줄을 입력받거나 출력할 때 시간초과가 날 수 있다는 점이다.

C++을 사용하고 있고 cin/cout을 사용하고자 한다면, cin.tie(NULL)과 sync_with_stdio(false)를 둘 다 적용해 주고, endl 대신 개행문자(\n)를 쓰자. 단, 이렇게 하면 더 이상 scanf/printf/puts/getchar/putchar 등 C의 입출력 방식을 사용하면 안 된다.

https://www.acmicpc.net/problem/15552 (빠른 A+B)
https://www.acmicpc.net/board/view/22716 (추가 설명 및 다른 언어 빠른 입출력 방법)
 */

// 5
// 1 1			->	2
// 12 34		->	46
// 5 500		->	505
// 40 60		->	100
// 1000 1000	->	2000

#include <iostream>
#include <string>

using namespace std;

int main(void)
{
	int n, m;
	int i;

	cin.tie(NULL);
	// cin과 cout의 묶음을 풀어줍니다.
	//
	// 기본적으로 cin으로 읽을 때 먼저 출력 버퍼를 비우는데,
	// 마찬가지로 온라인 저지에서는 입력 하자마자 바로 화면에 보여지는 것이
	// 중요하지 않습니다. (= 입력을 전부 받고 한 번에 출력해도 상관 없습니다.)
	//
	// 입력과 출력을 여러 번 번갈아서 반복해야 하는 경우 필수적입니다.

	ios_base::sync_with_stdio(false);
	// C와 C++의 버퍼를 분리합니다.
	//
	// 이것을 사용하면 cin/cout이 더 이상 stdin/stdout과 맞춰 줄 필요가
	// 없으므로 속도가 빨라집니다.
	//
	// 단, 버퍼가 분리되었으므로,
	// cin과 scanf, gets, getchar 등을 같이 사용하면 안 되고
	// cout과 printf, puts, putchar 등을 같이 사용하면 안 됩니다.

	cin >> i;
	while (i-- > 0)
	{
		cin >> n >> m;
		cout << n + m << "\n";
	}

	return (0);
}

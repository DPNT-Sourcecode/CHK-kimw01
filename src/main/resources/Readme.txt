+------+-------+------------------------+
| Item | Price | Special offers         |
+------+-------+------------------------+
| A    | 50    | 3A for 130, 5A for 200 |
| B    | 30    | 2B for 45              |
| C    | 20    |                        |
| D    | 15    |                        |
| E    | 40    | 2E get one B free      |
| F    | 10    | 2F get one F free      |
+------+-------+------------------------+

 - {"method":"checkout","params":["FF"],"id":"CHK_R3_039"}, expected: 20, got: 10
 CASE 1: 1 pack 2F get one free only when there is more than 2 item reference
 premise?: the 2F pack if there is only one pack cannot to be broke the pack
 - {"method":"checkout","params":["FFFF"],"id":"CHK_R3_041"}, expected: 30, got: 20
 CASE2: 2 packs of 2F, get free item before calculate if there is any other pack of 2F
 - {"method":"checkout","params":["FFFFFF"],"id":"CHK_R3_042"}, expected: 40, got: 30
 CASE3: 3 packs of 2F, first pack get free one, second pack get free one, the tihrd

 Wrong!: this means that when the special offer pack get one free item of the same product the free is out of the pack offer
+------+-------+------------------------+
| Item | Price | Special offers         |
+------+-------+------------------------+
| A    | 50    | 3A for 130, 5A for 200 |
| B    | 30    | 2B for 45              |
| C    | 20    |                        |
| D    | 15    |                        |
| E    | 40    | 2E get one B free      |
+------+-------+------------------------+
ABAAEACDAABAAEA

ABAAEACDAAAAEA
A=200+130+50 -> 380
B=30
C=20
D=15
E=40+40 = 80
Total 525

 - {"method":"checkout","params":["B"],"id":"CHK_R2_004"}, expected: 30, got: 80
 - {"method":"checkout","params":["C"],"id":"CHK_R2_005"}, expected: 20, got: 100
 - {"method":"checkout","params":["D"],"id":"CHK_R2_006"}, expected: 15, got: 115
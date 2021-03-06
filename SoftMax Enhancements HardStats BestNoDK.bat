@echo off
cd ./bin
echo Starting Mixmax STATS

echo %DATE% %TIME%

echo Testing Mixmax
java itu.ejuuragr.HardStats itu.ejuuragr.UCT.EnhancementTester 0 6 0.25 0 1 1 1 0 0 0 >> "Enhancement BestNoDK 0.txt"
echo Completed test (1/7)

echo %DATE% %TIME%

echo Testing Mixmax
java itu.ejuuragr.HardStats itu.ejuuragr.UCT.EnhancementTester 0 6 0.25 0.125 1 1 1 0 0 0 >> "Enhancement BestNoDK 0.125.txt"
echo Completed test (2/7)

echo %DATE% %TIME%

echo Testing Mixmax
java itu.ejuuragr.HardStats itu.ejuuragr.UCT.EnhancementTester 0 6 0.25 0.25 1 1 1 0 0 0 >> "Enhancement BestNoDK 0.25.txt"
echo Completed test (3/7)

echo %DATE% %TIME%

echo Testing Mixmax
java itu.ejuuragr.HardStats itu.ejuuragr.UCT.EnhancementTester 0 6 0.25 0.375 1 1 1 0 0 0 >> "Enhancement BestNoDK 0.375.txt"
echo Completed test (4/7)

echo %DATE% %TIME%

echo Testing Mixmax
java itu.ejuuragr.HardStats itu.ejuuragr.UCT.EnhancementTester 0 6 0.25 0.5 1 1 1 0 0 0 >> "Enhancement BestNoDK 0.5.txt"
echo Completed test (5/7)

echo %DATE% %TIME%

echo Testing Mixmax
java itu.ejuuragr.HardStats itu.ejuuragr.UCT.EnhancementTester 0 6 0.25 0.75 1 1 1 0 0 0 >> "Enhancement BestNoDK 0.75.txt"
echo Completed test (6/7)

echo %DATE% %TIME%

echo Testing Mixmax
java itu.ejuuragr.HardStats itu.ejuuragr.UCT.EnhancementTester 0 6 0.25 1 1 1 1 0 0 0 >> "Enhancement BestNoDK 1.txt"
echo Completed test (7/7)

echo %DATE% %TIME%
echo ALL DONE
echo ALL DONE
echo ALL DONE
pause

DO
   $$
     DECLARE
        ROW RECORD;
    BEGIN
	   FOR ROW IN
                    select * FROM student
            LOOP
                UPDATE public.student SET last_name = ROW.first_name
				where ROW.id = student.id;
       END  LOOP;
    END
  $$;

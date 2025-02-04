import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { getPatientReport } from '../services/patientService';

const PatientReport = () => {
  const { id } = useParams();
  const [report, setReport] = useState(null);

  useEffect(() => {
    const fetchReport = async () => {
      const data = await getPatientReport(id);
      setReport(data);
    };
    fetchReport();
  }, [id]);

  return (
    <div>
      {report ? (
        <div>
          <h2>Patient Report</h2>
          <p>{report.details}</p>
        </div>
      ) : (
        <p>Loading...</p>
      )}
    </div>
  );
};

export default PatientReport;

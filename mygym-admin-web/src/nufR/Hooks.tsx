import { useEffect, useState } from "react";
import { defaultConfig } from "./pages/ListPage";
import { IConfig } from "./pages/ListPage";

export function useConfig(configname: string) {

    const [loading, setLoading] = useState(true);
    const [config, setConfig] = useState<IConfig>(defaultConfig);

    useEffect(() => {
        const fetchData = async () => {
            setLoading(true);
            import("../nufrConfig/" + configname + "Config").then(c => {
                setConfig(c.default);
                console.log('confg loaded!');
                setLoading(false);
            });
        };
        fetchData();
    }, []);

    return { config, loading } as const;
}
